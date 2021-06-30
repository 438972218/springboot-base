package com.xdcplus.xdcweb.global.config;

import cn.hutool.core.io.FileUtil;
import com.xdcplus.xdcweb.global.constants.FileConstant;
import com.xdcplus.xdcweb.global.constants.NumberConstant;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 *  文件上传管理
 * @author Rong.Jia
 * @date 2021/04/29 08:58
 */
@Configuration
public class FileUploadConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();

        //路径有可能限制
        FileUtil.mkdir(FileConstant.TMP_DIR);

        factory.setLocation(FileConstant.TMP_DIR);

        // 当上传文件达到10MB的时候进行磁盘写入
        factory.setFileSizeThreshold(DataSize.ofMegabytes(NumberConstant.TWENTY));

        /*
         * 设置文件大小限制
         * 大小：KB,MB
         */
        factory.setMaxFileSize(DataSize.ofMegabytes(NumberConstant.ONE_THOUSAND_AND_TWENTY_FOUR));

        //设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(NumberConstant.ONE_THOUSAND_AND_TWENTY_FOUR));

        return factory.createMultipartConfig();
    }

}
