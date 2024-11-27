package com.parking.member.mapper;

import com.parking.common.model.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leezw
 * @description 会员信息Mapper
 * @date 2024-11-26
 */
@Mapper
@Repository
public interface MemberMapper {

    @Select("select * from member where member_id=#{id}")
    public Member getById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "memberId")
    @Insert("insert into member " +
            " (id,phone,birth,full_name,create_by,create_date,update_by,update_date,remark,version,state)" +
            " values(#{id},#{phone},#{birth},#{fullName},#{createBy},#{createDate},#{updateBy},#{updateDate},#{remark},#{version},#{state})")
    public Integer insert(Member member);

    @Delete(value = "delete from member where member_id=#{memberId}")
    boolean delete(Integer id);

    @Update(value = "update member set "

            + " phone=#{phone},"
            + " birth=#{birth},"
            + " full_name=#{fullName},"
            + " create_by=#{createBy},"
            + " create_date=#{createDate},"
            + " update_by=#{updateBy},"
            + " update_date=#{updateDate},"
            + " remark=#{remark},"
            + " version=#{version},"
            + " state=#{state}"
            + " where member_id=#{memberId} ")
    boolean update(Member member);


    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "birth", column = "birth"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "version", column = "version"),
            @Result(property = "state", column = "state")
    })
    @Select(value = "select * from member where member_id=#{queryParam}")
    Member selectOne(String queryParam);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "birth", column = "birth"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateBy", column = "update_by"),
            @Result(property = "updateDate", column = "update_date"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "version", column = "version"),
            @Result(property = "state", column = "state")
    })
    @Select(value = "select * from member where "
            + " id=#{id} or "
            + " phone=#{phone} or "
            + " birth=#{birth} or "
            + " full_name=#{fullName} or "
            + " create_by=#{createBy} or "
            + " create_date=#{createDate} or "
            + " update_by=#{updateBy} or "
            + " update_date=#{updateDate} or "
            + " remark=#{remark} or "
            + " version=#{version} or "
            + " state=#{state}"
    )
    List<Member> selectList(Member member);

}