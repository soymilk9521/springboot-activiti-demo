import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.spring.impl.test.SpringActivitiTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/01 17:39
 * 作用： 测试actiiviti所需要的25张表
 */
public class ActivitiTest {
    @Test
    public void testGenerateTables() {
        // 1. 创建ProcessEngineConfiguration对象:第一参数配置文件名称，第二个参数bean id
        ProcessEngineConfiguration configuration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 2. 创建ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    public void testGenTables() {
        // 快捷方式生效条件：
        // 1. 配置文件名称必须为activiti.cfg.xml
        // 2. 配置文件中的bean id必须为processEngineConfiguration
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }
}
