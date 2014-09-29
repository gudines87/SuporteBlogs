package testeUnidade;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Classe de teste suite, ela executa todos os testes cases.
 * @author Clarice Maria
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestJDBCAnexoDAO.class, TestJDBCBlogDAO.class,
		TestJDBCComentarioDAO.class, TestJDBCPostDAO.class,
		TestJDBCProfileDAO.class })
public class TestSuite {

}
