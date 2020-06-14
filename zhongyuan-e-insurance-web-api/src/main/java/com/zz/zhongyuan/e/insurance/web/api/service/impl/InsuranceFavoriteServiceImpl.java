package com.zz.zhongyuan.e.insurance.web.api.service.impl;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.InsuranceFavorite;
import com.zz.zhongyuan.e.insurance.web.api.dao.InsuranceFavoriteDao;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * ClassName: InsuranceFavoriteServiceImpl
 * Description: <br/>
 * date: 2020/4/24 20:49
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
public class InsuranceFavoriteServiceImpl implements InsuranceFavoriteService {
    @Autowired
    private InsuranceFavoriteDao insuranceFavoriteDao;

    @Override
    public List<InsuranceFavorite> selectAll() {
        return insuranceFavoriteDao.selectAll();
    }

    @Override
    public List<InsuranceFavorite> getByOuId(Long ouid) {
        return insuranceFavoriteDao.getByOuId(ouid);
    }

    @Override
    public BaseResult insert(InsuranceFavorite insuranceFavorite) {
        List<InsuranceFavorite> insuranceFavorites=insuranceFavoriteDao.selectAll();
        for (InsuranceFavorite favorite : insuranceFavorites){
            if (insuranceFavorite.getInsurance().getIid().equals(favorite.getInsurance().getIid())){
                return BaseResult.fail("加入收藏失败");
            }
        }
        insuranceFavorite.setCreated(new Date());
        insuranceFavorite.setUpdated(new Date());
        insuranceFavoriteDao.insert(insuranceFavorite);
        return BaseResult.success("加入收藏成功");
    }

    @Override
    public BaseResult delete(Long iid,Long ouid) {
        if(iid==null || ouid==null){
            return BaseResult.fail("删除收藏失败");
        }else{
            insuranceFavoriteDao.delete(iid,ouid);
            return BaseResult.success("删除收藏成功");
        }
    }
}
