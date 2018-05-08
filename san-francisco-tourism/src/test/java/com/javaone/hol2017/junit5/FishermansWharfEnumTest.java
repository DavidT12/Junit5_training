package com.javaone.hol2017.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


public class FishermansWharfEnumTest {

	private FishermansWharfEnum current;

	@ParameterizedTest
	@EnumSource(FishermansWharfEnum.class)
	public void allClosingTimesAfter9pm(FishermansWharfEnum current) {
		LocalTime ninePm = LocalTime.of(12 + 9, 0);
		assertThat(current + " should close after 9pm", current.closes(), greaterThanOrEqualTo(ninePm));

	}




//	@Test
//	public void allClosingTimesAfter9pm() {
//		LocalTime ninePm = LocalTime.of(12 + 9, 0);
//		for (FishermansWharfEnum current : FishermansWharfEnum.values()) {
//			assertThat(current + " should close after 9pm", current.closes(), greaterThanOrEqualTo(ninePm));
//		}
//	}


}
