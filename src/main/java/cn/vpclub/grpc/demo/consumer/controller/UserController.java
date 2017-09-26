package cn.vpclub.grpc.demo.consumer.controller;

import cn.vpclub.grpc.demo.consumer.domain.User;
import cn.vpclub.grpc.demo.consumer.domain.response.BaseResponse;
import cn.vpclub.grpc.demo.consumer.enums.ReturnCodeEnum;
import cn.vpclub.grpc.demo.consumer.service.UserRpcService;
import cn.vpclub.moses.utils.common.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WangRui on 2017/9/21.
 */
@Slf4j
@RestController
@RequestMapping("/user")
//@CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserRpcService userRpcService;

    /**
     * 查询用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/findUser", method = {RequestMethod.POST})
    public User findUser(@RequestBody User param) {
        User user = userRpcService.findUser(param);
        return user;
    }

    /**
     * 新增用户信息
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
    public BaseResponse insertUser(@RequestBody User param) {
        if (null == param || StringUtil.isEmpty(param.getUsername())) {
            return ReturnCodeEnum.CODE_1011.getBaseResponse("用户姓名");
        }
        BaseResponse baseResponse = userRpcService.insertUser(param);
        return baseResponse;
    }

    /**
     * 更新用户信息
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST})
    public BaseResponse updateUser(@RequestBody User param) {
        if (null == param || StringUtil.isEmpty(param.getUsername())) {
            return ReturnCodeEnum.CODE_1011.getBaseResponse("用户姓名");
        }
        BaseResponse baseResponse = userRpcService.updateUser(param);
        return baseResponse;
    }
}
