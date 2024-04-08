import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.vehmanage.Application;
import com.jxd.vehmanage.dao.MenuMapper;
import com.jxd.vehmanage.dao.UserMapper;
import com.jxd.vehmanage.dao.VehappliMapper;
import com.jxd.vehmanage.dao.VehicleMapper;
import com.jxd.vehmanage.model.Vehappli;
import com.jxd.vehmanage.model.Vehicle;
import com.jxd.vehmanage.service.IUserService;
import com.jxd.vehmanage.service.IVehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/28
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test01 {

    @Autowired
    IUserService userService;

    @Autowired
    VehicleMapper vehicleMapper;

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    VehappliMapper vehappliMapper;

    @Test
    public void get(){

    }
}
