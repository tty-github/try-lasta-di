package com.example.di;

import java.lang.reflect.Method;

import javax.transaction.Transactional;

import org.lastaflute.di.core.ComponentDef;
import org.lastaflute.di.core.customizer.PointTxAttributeCustomizer;
import org.lastaflute.di.core.factory.AspectDefFactory;
import org.lastaflute.di.util.LdiStringUtil;

/**
 *
 */
public class TxAttributeCustomizer extends PointTxAttributeCustomizer {

    /** デフォルトのトランザクション属性 */
    protected Transactional.TxType defaultAttributeType = Transactional.TxType.REQUIRED;

    @Override
    protected void doCustomize(ComponentDef componentDef) {
        final Class<?> componentClass = componentDef.getComponentClass();
        final Transactional classTx = componentClass.getAnnotation(Transactional.class);
        final Transactional.TxType classTxType = classTx != null ? classTx.value() : defaultAttributeType;
        for (final Method method : componentClass.getMethods()) {
            if (method.isSynthetic() || method.isBridge()) {
                continue;
            }
            if (method.getDeclaringClass() == Object.class) {
                continue;
            }
            final Transactional methodTx = method.getAnnotation(Transactional.class);
            final Transactional.TxType methodTxType = methodTx != null ? methodTx.value() : classTxType;
            final String interceptorName = txInterceptors.get(methodTxType);
            if (LdiStringUtil.isNotEmpty(interceptorName)) {
                componentDef.addAspectDef(AspectDefFactory.createAspectDef(interceptorName, method));
            }
        }
    }

    @Override
    protected boolean isImplicitTxSupportedMethod(Method method) {
        return false;
    }

}
