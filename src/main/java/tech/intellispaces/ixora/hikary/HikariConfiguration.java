package tech.intellispaces.ixora.hikary;

import intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryHandle;
import intellispaces.ixora.rdb.hikary.HikariDataSourcePropertiesHandle;
import intellispaces.ixora.rdb.hikary.MovableHikariDataSourceHandle;
import tech.intellispaces.core.annotation.Configuration;
import tech.intellispaces.core.annotation.Projection;
import tech.intellispaces.core.annotation.Properties;

@Configuration
public abstract class HikariConfiguration {

  @Projection
  @Properties("datasource")
  public abstract HikariDataSourcePropertiesHandle hikariDataSourceProperties();

  @Projection
  public HikariDataSourceFactoryHandle hikariDataSourceFactory() {
    return new HikariDataSourceFactory();
  }

  @Projection
  public MovableHikariDataSourceHandle dataSource(
      HikariDataSourceFactoryHandle hikariDataSourceFactory,
      HikariDataSourcePropertiesHandle hikariDataSourceProperties
  ) {
    return hikariDataSourceFactory.create(hikariDataSourceProperties).asMovableOrElseThrow();
  }
}
