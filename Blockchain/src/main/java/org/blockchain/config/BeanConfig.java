package org.blockchain.config;

import com.google.gson.Gson;
import org.blockchain.core.Blockchain;
import org.blockchain.core.Node;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@Configuration
public class BeanConfig {

    @Bean
    public Gson gsonBean(){
        return new Gson();
    }

    @Bean
    public Blockchain initBlockchain(){
        return new Blockchain();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
