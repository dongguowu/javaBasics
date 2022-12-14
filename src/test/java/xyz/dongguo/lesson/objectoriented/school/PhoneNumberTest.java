package xyz.dongguo.lesson.objectoriented.school;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.dongguo.lesson.objectoriented.school.PhoneNumber;

class PhoneNumberTest {

  private String phoneNumberStr;
  private int phoneNumberLength;
  private PhoneNumber phoneNumber;

  @BeforeEach
  void setupEach() {
    phoneNumberStr = "5148131234";
    phoneNumberLength = phoneNumberStr.length();
    phoneNumber = new PhoneNumber(phoneNumberStr);
  }

  @Test
  void main() {
    PhoneNumber.main(new String[1]);
    assertTrue(Boolean.TRUE);
  }

  @Test
  void createPhoneList() {
    List<PhoneNumber> list = PhoneNumber.createPhoneList();
    assertFalse(list.isEmpty());
  }

  @Test
  void getNumber() {
    assertEquals(phoneNumberStr, phoneNumber.getNumber());
  }

  @Test
  void setNumberWhenInvalidInput_ThrowException() {
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(null));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(""));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("123456789X"));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("123459"));
  }

  @Test
  void setNumber() {

    assertNotNull(phoneNumber);
    assertEquals(PhoneNumber.class, phoneNumber.getClass());
    assertNotNull(phoneNumber.getNumber());
    assertEquals(phoneNumberStr, phoneNumber.getNumber());
  }

  @Test
  void getFormattedNumber() {
    String result = phoneNumber.getFormattedNumber();
    assertNotNull(result);
    assertEquals(phoneNumberStr.substring(phoneNumberLength - 4),
       result.substring(result.length() - 4));
  }
}