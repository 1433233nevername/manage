package com.zb.manage.biz.service;

import com.zb.manage.dal.mapper.SelectionMapper;
import com.zb.manage.dal.model.Selection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class SelectionService {
    @Resource
    private SelectionMapper selectionMapper;

    public List<Selection> findAll() {
        return selectionMapper.findAll();
    }

    public Selection getByTescore(String tescore) {
        return selectionMapper.findByTescore(tescore);
    }

    public void add(BigInteger id, String stuid, String lesid,String tescore) {
        Selection selection = new Selection();
        selection.setId(id);
        selection.setStuid(stuid);
        selection.setLesid(lesid);
        selection.setTescoree(tescore);
        selection.setSetime(new Date());
        selectionMapper.add(selection);
    }

    public void delete(BigInteger id) {
        selectionMapper.delete(id);
    }

    public void update(Selection selection) {
        selectionMapper.update(selection);
    }

    public Selection getById(BigInteger id) {
        return selectionMapper.getById(id);
    }
}

