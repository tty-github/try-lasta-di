package com.example.app.logic;

import java.util.List;

import com.example.db.exentity.Member;

public class BarLogic extends AbstractLogic{

    public void selectList() {
        List<Member> list = bhv.selectList((cb) -> {
            cb.query().setMemberStatusCode_Equal_Formalized();
            cb.query().addOrderBy_MemberId_Asc();
        });
        for (Member member : list) {
            log.info(member.getMemberName());
        }
    }

}
