package cn.vpclub.grpc.demo.consumer.service;

import cn.vpclub.grpc.demo.consumer.domain.User;
import cn.vpclub.grpc.demo.consumer.domain.response.BaseResponse;
import cn.vpclub.grpc.demo.user.consumer.api.AdapterUserProto;
import cn.vpclub.grpc.demo.user.consumer.api.AdapterUserServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.vpclub.moses.utils.grpc.GRpcMessageConverter.fromGRpcMessage;
import static cn.vpclub.moses.utils.grpc.GRpcMessageConverter.toGRpcMessage;

/**
 * 通过grpc转换数据服务层
 * Created by WangRui on 2017/9/21.
 */
@Service
public class UserRpcService {

    @Autowired
    private AdapterUserServiceGrpc.AdapterUserServiceBlockingStub blockingStub;

    /**
     * 查询
     *
     * @param user
     * @return
     */
    public User findUser(User user) {
        AdapterUserProto.User request = (AdapterUserProto.User) toGRpcMessage(user, AdapterUserProto.User.newBuilder());
        AdapterUserProto.User response = blockingStub.findUser(request);
        return (User) fromGRpcMessage(response, User.class);
    }

    /**
     * 新增
     *
     * @param user
     * @return
     */
    public BaseResponse insertUser(User user) {
        AdapterUserProto.User request = (AdapterUserProto.User) toGRpcMessage(user, AdapterUserProto.User.newBuilder());
        AdapterUserProto.UserResponse response = blockingStub.insertUser(request);
        return (BaseResponse) fromGRpcMessage(response, BaseResponse.class);
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    public BaseResponse updateUser(User user) {
        AdapterUserProto.User request = (AdapterUserProto.User) toGRpcMessage(user, AdapterUserProto.User.newBuilder());
        AdapterUserProto.UserResponse response = blockingStub.updateUser(request);
        return (BaseResponse) fromGRpcMessage(response, BaseResponse.class);
    }
}
