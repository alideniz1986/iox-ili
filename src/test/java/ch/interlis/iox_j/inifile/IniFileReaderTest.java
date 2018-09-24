package ch.interlis.iox_j.inifile;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import ch.interlis.iox_j.validator.ValidationConfig;

public class IniFileReaderTest {
    @Test
    public void comments() throws Exception {
        ValidationConfig ini = IniFileReader.readFile(new File("src/test/data/inifile/comments.ini"));
        assertNotNull(ini.getConfigParams("Beispiel1.Bodenbedeckung.Gebaeude"));
        assertEquals("Assekuranz-Nr {AssNr}", ini.getConfigValue("Beispiel1.Bodenbedeckung.Gebaeude", "keymsg.de"));
    }

    @Test
    public void withQuotes() throws Exception {
        ValidationConfig ini = IniFileReader.readFile(new File("src/test/data/inifile/withQuotes.ini"));
        assertNotNull(ini.getConfigParams("Beispiel1.Bodenbedeckung.Gebaeude"));
        assertEquals("Assekuranz-Nr {AssNr}", ini.getConfigValue("Beispiel1.Bodenbedeckung.Gebaeude", "keymsg.de"));
    }

    @Test
    public void noQuotes() throws Exception {
        ValidationConfig ini = IniFileReader.readFile(new File("src/test/data/inifile/noQuotes.ini"));
        assertNotNull(ini.getConfigParams("Beispiel1.Bodenbedeckung.Gebaeude"));
        assertEquals("Assekuranz-Nr {AssNr}", ini.getConfigValue("Beispiel1.Bodenbedeckung.Gebaeude", "keymsg.de"));
    }
    
    @Test
    public void headerWithError() throws Exception {
        ValidationConfig ini = IniFileReader.readFile(new File("src/test/data/inifile/headerWithError.ini"));
        assertEquals(null, ini.getConfigParams("Beispiel1.Bodenbedeckung.Gebaeude"));
    }    

}