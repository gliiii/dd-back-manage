package com.glii.ddbackmanage.utils;

import com.glii.ddbackmanage.vo.ResultVO;
import org.springframework.http.HttpStatus;

public class ResultVOUtil {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpStatus.OK.value());
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpStatus.OK.value());
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(Object data,long count) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(HttpStatus.OK.value());
        resultVO.setMsg("成功");
        resultVO.setCount(count);
        resultVO.setData(data);
        return resultVO;
    }
}
