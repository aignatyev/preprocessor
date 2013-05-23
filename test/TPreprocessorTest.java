import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 23.05.13
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public class TPreprocessorTest {
    TPreprocessor tPreprocessor= new TPreprocessor();

    @Test
    public void testSimpleDefine() {
        assertEquals("", tPreprocessor.parse("#define A 1\n"));
    }

    @Test
    public void testSimpleMainFlow() {
        assertEquals("select table1\nselect table2", tPreprocessor.parse("select table1\nselect table2"));
    }

    @Test
    public void testSimpleDefineUndefine() {
        assertEquals("select table2", tPreprocessor.parse("#define a 1\n#undefine a\nselect table2"));
    }

    @Test
    public void testSimpleIf() {
        assertEquals("select table1", tPreprocessor.parse("#define a 1\n#if a>0\nselect table1\n#end if"));
    }


}
