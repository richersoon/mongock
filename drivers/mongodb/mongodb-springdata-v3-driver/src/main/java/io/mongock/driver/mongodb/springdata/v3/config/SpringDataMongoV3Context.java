package io.mongock.driver.mongodb.springdata.v3.config;

import io.mongock.api.config.MongockConfiguration;
import io.mongock.driver.mongodb.springdata.v3.SpringDataMongoV3Driver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

@Configuration
@ConditionalOnExpression("${mongock.enabled:true}")
@ConditionalOnBean(MongockConfiguration.class)
@EnableConfigurationProperties(MongoDBConfiguration.class)
public class SpringDataMongoV3Context extends SpringDataMongoV3ContextBase<MongockConfiguration, SpringDataMongoV3Driver> {

  @Override
  protected SpringDataMongoV3Driver buildDriver(MongoTemplate mongoTemplate,
                                                MongockConfiguration config,
                                                MongoDBConfiguration mongoDbConfig) {
    return SpringDataMongoV3Driver.withLockStrategy(
        mongoTemplate,
        config.getLockAcquiredForMillis(),
        config.getLockQuitTryingAfterMillis(),
        config.getLockTryFrequencyMillis());
  }

}

