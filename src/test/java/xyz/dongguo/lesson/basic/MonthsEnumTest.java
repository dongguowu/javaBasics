package xyz.dongguo.lesson.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import xyz.dongguo.lesson.basic.MonthsEnum;

class MonthsEnumTest {

  private final String[] MonthsArray = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST",
     "SEPTEMBER",
     "OCTOBER", "NOVEMBER", "DECEMBER"};
  private final int[] daysOfMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  @Test
  void getOrder() {
    int order = 0;
    for (MonthsEnum m : MonthsEnum.values()) {
      assertEquals(order, m.getIndex());
      order++;
    }
  }

  @Test
  void getDays() {
    assertEquals(31, MonthsEnum.JANUARY.getDays(true));
    assertEquals(29, MonthsEnum.FEBRUARY.getDays(true));
    assertEquals(28, MonthsEnum.FEBRUARY.getDays(false));
    int index = 0;
    for (MonthsEnum m : MonthsEnum.values()) {
      assertEquals(daysOfMonths[index], m.getDays());
      index++;
    }
  }

  @Test
  void getMonth() {
    for (int order = 0; order <= 11; order++) {
      MonthsEnum m = MonthsEnum.getMonth(order);
      assert m != null;
      assertEquals(MonthsArray[order], m.name());
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 12, 13})
  void getMonthReturnNull(int order) {
    assertNull(MonthsEnum.getMonth(order));
  }

  @Test
  void values() {
    int index = 0;
    for (MonthsEnum month : MonthsEnum.values()) {
      assertEquals(MonthsArray[index], month.toString());
      index++;
    }
  }

  @Test
  void valueOf() {
    MonthsEnum jan = Enum.valueOf(MonthsEnum.class, MonthsArray[0]);
    assertEquals(MonthsEnum.JANUARY, jan);
    for (int i = 0; i < 12; i++) {
      MonthsEnum m = Enum.valueOf(MonthsEnum.class, MonthsArray[i]);
      assertEquals(MonthsEnum.getMonth(i), m);
    }
  }

  @ParameterizedTest
  @ValueSource(ints = {1600, 2000, 1996, 2004, 2400})
  void isLeapReturnTrueTest(int year) {
    assertTrue(MonthsEnum.isLeap(year));
  }

  @ParameterizedTest
  @ValueSource(ints = {1900, 1999, 2001, 2002, 2003, 2005, 2100})
  void isLeapReturnFalseTest(int year) {
    assertFalse(MonthsEnum.isLeap(year));
  }

}
