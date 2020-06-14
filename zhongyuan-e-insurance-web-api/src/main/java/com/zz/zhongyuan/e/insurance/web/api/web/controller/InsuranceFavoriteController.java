package com.zz.zhongyuan.e.insurance.web.api.web.controller;

import com.zz.zhongyuan.e.insurance.commons.dto.BaseResult;
import com.zz.zhongyuan.e.insurance.domain.InsuranceFavorite;
import com.zz.zhongyuan.e.insurance.domain.InsuranceOrders;
import com.zz.zhongyuan.e.insurance.web.api.service.InsuranceFavoriteService;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.InsuranceFavoriteDTO;
import com.zz.zhongyuan.e.insurance.web.api.web.dto.InsuranceOrdersDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsuranceFavoriteController
 * Description: <br/>
 * date: 2020/4/24 20:50
 *
 * @author ZZ
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "/api/favorite")
public class InsuranceFavoriteController {
    @Autowired
    private InsuranceFavoriteService insuranceFavoriteService;

    /**
     * 收藏列表接口
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public BaseResult list(Long ouid) {
        List<InsuranceFavoriteDTO> insuranceFavoriteDTOS = null;
        List<InsuranceFavorite> insuranceFavorites = insuranceFavoriteService.getByOuId(ouid);
        if (insuranceFavorites != null && insuranceFavorites.size() > 0) {
            insuranceFavoriteDTOS = new ArrayList<>();
            for (InsuranceFavorite insuranceFavorite : insuranceFavorites) {
                InsuranceFavoriteDTO dto = new InsuranceFavoriteDTO();
                BeanUtils.copyProperties(insuranceFavorite, dto);
                insuranceFavoriteDTOS.add(dto);
            }
        }
        return BaseResult.success("成功", insuranceFavoriteDTOS);
    }

    /**
     * 提交订单接口
     * @param insuranceFavorite
     * @return
     */
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public BaseResult insert(InsuranceFavorite insuranceFavorite){
        BaseResult baseResult= insuranceFavoriteService.insert(insuranceFavorite);
        if (baseResult.getStatus()==500){
            return BaseResult.fail("加入收藏失败");
        }
        else{
            InsuranceFavoriteDTO dto = new InsuranceFavoriteDTO();
            BeanUtils.copyProperties(insuranceFavorite, dto);
            return BaseResult.success("加入收藏成功",dto);
        }
    }

    /**
     * 提交订单接口
     * @param iid
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public BaseResult delete(Long iid,Long ouid){
        BaseResult baseResult= insuranceFavoriteService.delete(iid,ouid);
        if (baseResult.getStatus()==500){
            return BaseResult.fail("删除收藏失败");
        }
        else{
            return BaseResult.success("删除收藏成功");
        }
    }

}
