package com.javaone.hol2017.junit5;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.*;



public class FishermansWharfEnumTest {
	private FishermansWharfEnum current;

	@ParameterizedTest
	@EnumSource(FishermansWharfEnum.class)
	public void allClosingTimesAfter9pm() {


		LocalTime ninePm = LocalTime.of(12 + 9, 0);
		assertThat(current + " should close after 9pm",	current.closes(), greaterThanOrEqualTo(ninePm));


	}

}
