package com.javaone.hol2017.junit5;

import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@RunWith(Parameterized.class)
public class ThirtyNinthAnniversaryEventsTest {
	
	@Parameter(0) public LocalDate date;
	@Parameter(1) public boolean expectedResult;

	@Parameters(name="{0}")
	@CsvFileSource(resources = { "/39-tests.txt" })
	public static Collection<Object[]> testCases() throws IOException {
		Path path = Paths.get("src/test/resources", "39-tests.txt");
		return Files.lines(path)
				// remove blank and commented out lines
				.filter(l -> ! l.isEmpty())
				.filter(l -> ! l.startsWith("#"))
				// convert to array
				.map(l -> l.split(","))
				// convert to desired types for parameterized test
				.map(a -> new Object[] { LocalDate.parse(a[0]), Boolean.parseBoolean(a[1])} )
				// store in collection
				.collect(Collectors.toList());
	}

	@ParameterizedTest(name = "{0}")
	public void date() {
		boolean actual = ThirtyNinthAnniversaryEvents.isCelebrationDay(date);
		assertEquals(expectedResult, actual);
	}

}
