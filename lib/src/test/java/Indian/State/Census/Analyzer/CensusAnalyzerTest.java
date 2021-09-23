package Indian.State.Census.Analyzer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_TYPE_PATH = "./src/test/resources/IndiaStateCensusData.txt";
	private static final String INVALID_DELIMITER_FILE_PATH = "./src/test/resources/invalidDelimitersIndiaStateCensusData.csv";
	private static final String INVALID_HEADER_FILE_PATH = "./src/test/resources/invalidHeadersIndiaStateCensusData.csv";

	// Test Case 1.1
	@Test
	public void givenIndianCensusDataCSVFileReturnsCorrectRecords() {
		try {
			CensusAnalyzer censusAnalyser = new CensusAnalyzer();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	// Test Case 1.2
	@Test
	public void givenIndianCensusDataCSVFile_whenWithWrongPath_shouldThrowException() {
		CensusAnalyzer censusAnalyser = new CensusAnalyzer();
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	// Test Case 1.3
	@Test
	public void givenIndianCensusDataCSVFile_whenWithWrongFileType_shouldThrowException() {
		CensusAnalyzer censusAnalyser = new CensusAnalyzer();
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_TYPE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertNotEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER,
					e.type);
		}
	}

	// Test Case 1.4
	@Test
	public void givenIndianCensusDataCSVFile_whenWithWrongDelimiters_shouldThrowException() {
		CensusAnalyzer censusAnalyser = new CensusAnalyzer();
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaCensusData(INVALID_DELIMITER_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertNotEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER,
					e.type);
		}
	}

	// Test Case 1.5
	@Test
    public void givenIndianCensusDataCSVFile_whenWithWrongHeaders_shouldThrowException() 
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try 
        {
            censusAnalyser.loadIndiaCensusData(INVALID_HEADER_FILE_PATH);
        } 
        catch (CensusAnalyserException e) 
        {
            Assert.assertNotEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }
	
	//Test Case 2.1
    @Test
    public void givenIndiaStateCodeCSVFileReturnsCorrectRecords() 
    {
        try 
        {
            CensusAnalyzer censusAnalyser = new CensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaStateCode(INDIA_STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        } 
        catch (CensusAnalyserException e) { }
    }

    //Test Case 2.2
    @Test
    public void givenIndianStateCodeCSVFile_whenWithWrongPath_shouldThrowException() 
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try 
        {
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CODE_CSV_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    //Test Case 2.3
    @Test
    public void givenIndianStateCodeCSVFile_whenWithWrongFileType_shouldThrowException()
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try 
        {
            censusAnalyser.loadIndiaStateCode(WRONG_STATE_CODE_CSV_FILE_TYPE_PATH);
        } 
        catch (CensusAnalyserException e) 
        {
            Assert.assertNotEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }

    //Test Case 2.4
    @Test
    public void givenIndianStateCodeCSVFile_whenWithWrongDelimiters_shouldThrowException()
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try
        {
            censusAnalyser.loadIndiaStateCode(INVALID_STATE_CODE_CSV_DELIMITER_FILE_PATH);
        } 
        catch (CensusAnalyserException e)
        {
            Assert.assertNotEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }

    //Test Case 2.5
    @Test
    public void givenIndianStateCodeCSVFile_whenWithWrongHeaders_shouldThrowException() 
    {
        CensusAnalyzer censusAnalyser = new CensusAnalyzer();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyserException.class);
        try 
        {
            censusAnalyser.loadIndiaStateCode(INVALID_STATE_C0DE_CSV_HEADER_FILE_PATH);
        }
        catch (CensusAnalyserException e)
        {
            Assert.assertNotEquals(CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE_OR_DELIMITER_OR_HEADER, e.type);
        }
    }
}
}