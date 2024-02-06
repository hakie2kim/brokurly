import com.brokurly.entity.Order;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/root-context.xml"})
public class DBConnectionTest {
    @Autowired
    DataSource dataSource;

    @Test
    void connection() throws SQLException {
        Connection con = dataSource.getConnection();
        assertNotNull(con);
    }

    @Test
    void method(){
//        Order od = new Order();
//        od.setName("sfsd");
//        od.setNumber(1);
//        od.getName();
//        System.out.println("od = " + od);

    }
}