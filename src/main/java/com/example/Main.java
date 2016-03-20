package com.example;

import org.lastaflute.di.core.SingletonLaContainer;
import org.lastaflute.di.core.factory.SingletonLaContainerFactory;

import com.example.app.service.FooService;

public class Main {

    public static void main(String... args) {
        SingletonLaContainerFactory.init();
        try {
            FooService service = SingletonLaContainer.getComponent(FooService.class);
            service.exec();
        } finally {
            SingletonLaContainerFactory.destroy();
        }
    }

}
