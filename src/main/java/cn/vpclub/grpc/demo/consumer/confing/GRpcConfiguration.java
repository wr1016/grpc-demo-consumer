package cn.vpclub.grpc.demo.consumer.confing;

import cn.vpclub.grpc.demo.user.consumer.api.AdapterUserServiceGrpc;
import cn.vpclub.spring.boot.grpc.annotations.GRpcClient;
import io.grpc.ManagedChannel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务配置中心
 */
@Configuration
@EnableAutoConfiguration
public class GRpcConfiguration {

    /**
     * 注意，这里的名称和yml配置文件的名称对应
     * grpc\client\micro-service-provider:
     */
    @GRpcClient("grpc-demo-provider")
    private ManagedChannel serverChannel;

    /**
     * 注意：此处只能以工厂方法注入，忘记服务名称叫什么，请查看你的proto文件的描述定义
     * 或者到target\generated-sources\protobuf\grpc-java 目录查看
     */
    @Bean
    public AdapterUserServiceGrpc.AdapterUserServiceBlockingStub adapterServorderServiceBlockingStub() {
        return AdapterUserServiceGrpc.newBlockingStub(serverChannel);
    }
}