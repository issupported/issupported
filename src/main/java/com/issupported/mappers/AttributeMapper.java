package com.issupported.mappers;

import com.issupported.model.Attribute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttributeMapper {

    @Select("SELECT * FROM attribute ORDER BY id")
    List<Attribute> getAll();
}
