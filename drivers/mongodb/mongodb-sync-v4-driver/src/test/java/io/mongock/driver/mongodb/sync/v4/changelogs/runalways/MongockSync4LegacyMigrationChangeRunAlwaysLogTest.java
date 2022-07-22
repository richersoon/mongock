package io.mongock.driver.mongodb.sync.v4.changelogs.runalways;

import io.mongock.driver.api.common.SystemChange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MongockSync4LegacyMigrationChangeRunAlwaysLogTest {


  @Test
  public void isAnnotated() {
    Assertions.assertTrue(MongockSync4LegacyMigrationChangeRunAlwaysLog.class.getAnnotation(SystemChange.class).updatesSystemTable());
  }

}
