package tech.intellispaces.ixora.rdb.hikary;

import intellispaces.ixora.rdb.DataSourcePropertiesHandle;
import tech.intellispaces.framework.core.annotation.Configuration;
import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSource;

@Configuration
public class HikariConfiguration {

  @Projection
  public HikariDataSource dataSource(DataSourcePropertiesHandle dataSourceProperties) {
    return new HikariDataSource(dataSourceProperties);
  }
}