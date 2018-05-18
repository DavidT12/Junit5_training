package com.javaone.hol2017.junit5;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;


public class ThirtyNinthAnniversaryEventsTest {

	@ParameterizedTest(name = "{0}")
	@CsvFileSource(resources = { "/39-tests.txt" })
	public void date(LocalDate date, boolean expectedResult) {
		boolean actual = ThirtyNinthAnniversaryEvents.isCelebrationDay(date);
		assertEquals(expectedResult, actual);
	}

}
