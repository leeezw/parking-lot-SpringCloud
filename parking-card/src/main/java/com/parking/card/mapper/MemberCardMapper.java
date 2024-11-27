package com.parking.card.mapper;

import com.parking.common.model.MemberCard;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 会员积分Mapper
 * @author zhengkai.blog.csdn.net
 * @date 2024-11-26
 */
@Mapper
@Repository
public interface MemberCardMapper {

    @Select("select * from member_card where member_card_id=#{id}")
    public MemberCard getById(Integer id);

    @Options(useGeneratedKeys=true,keyProperty="memberCardId")
    @Insert("insert into member_card" +
            " (id,member_id,cur_qty,create_by,create_date,update_by,update_date,remark,version,state)" +
            " values(#{id},#{memberId},#{curQty},#{createBy},#{createDate},#{updateBy},#{updateDate},#{remark},#{version},#{state})")
    public Integer insert(MemberCard memberCard);

    @Delete(value = "delete from member_card where member_card_id=#{memberCardId}")
    boolean delete(Integer id);

    @Update(value = "update member_card set "

            +" member_id=#{memberId},"
            +" cur_qty=#{curQty},"
            +" create_by=#{createBy},"
            +" create_date=#{createDate},"
            +" update_by=#{updateBy},"
            +" update_date=#{updateDate},"
            +" remark=#{remark},"
            +" version=#{version},"
            +" state=#{state}"
            +" where member_card_id=#{memberCardId} ")
    boolean update(MemberCard memberCard);


    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "memberId", column = "member_id"),
            @Result(property = "curQty", column = "cur_qty"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "version", column = "version"),
            @Result(property = "state", column = "state")
    })
    @Select(value = "select * from member_card where member_card_id=#{queryParam}")
    MemberCard selectOne(String queryParam);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "memberId", column = "member_id"),
            @Result(property = "curQty", column = "cur_qty"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "version", column = "version"),
            @Result(property = "state", column = "state")
    })
    @Select(value = "select * from member_card where "
            +" id=#{id} or "
            +" member_id=#{memberId} or "
            +" cur_qty=#{curQty} or "
            +" create_by=#{createBy} or "
            +" create_date=#{createDate} or "
            +" update_by=#{updateBy} or "
            +" update_date=#{updateDate} or "
            +" remark=#{remark} or "
            +" version=#{version} or "
            +" state=#{state}"
    )
    List<MemberCard> selectList(MemberCard memberCard);

}