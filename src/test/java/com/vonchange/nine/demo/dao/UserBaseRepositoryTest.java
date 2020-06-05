package com.vonchange.nine.demo.dao;

import com.vonchange.nine.demo.domain.SearchParam;
import com.vonchange.nine.demo.domain.UserBaseDO;
import com.vonchange.nine.demo.domain.UserBaseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
//@Slf4j
public class UserBaseRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(UserBaseRepositoryTest.class);

    @Resource
    private UserBaseRepository userBaseRepository;

    @Test
    public void findList() {
        List<UserBaseDO> userBaseDOList = userBaseRepository.findList("张三日子",LocalDateTime.now().plusHours(1L));
        userBaseDOList.forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
        });
    }

    @Test
    public void findListBase() {
        List<UserBaseDO> userBaseDOList = userBaseRepository.findListBase("张三日子");
        userBaseDOList.forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
        });
    }

    @Test
    public void findListByBean() {
        SearchParam searchParam = new SearchParam();
        searchParam.setUserName("张三日子");
        List<UserBaseDO> userBaseDOList = userBaseRepository.findListByBean(searchParam);
        userBaseDOList.forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
        });
    }
    @Test
    public void findListVo() {
        List<UserBaseVO> userBaseVOList = userBaseRepository.findListVo("张三日子",new Date());
        userBaseVOList.forEach(userBaseVO -> {
            log.info("\n {}",userBaseVO.toString());
        });
    }
    @Test
    public void findListByPage() {
        Pageable pageable = new PageRequest(0,3);
                //PageRequest.of(0,3);
        Page<UserBaseDO> personRepositoryBy = userBaseRepository.findList(pageable,"张三日子",null);
        log.info("\n {}",personRepositoryBy.toString());
        personRepositoryBy.getContent().forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
        });
    }
    @Test
    public void findUserName() {
        String userName = userBaseRepository.findUserName("test");
        log.info("\n userName {}",userName);
    }

    @Test
    public void findById() {
        UserBaseDO userBaseDO = userBaseRepository.findById(1L);
        log.info("\n userBaseDO {}",userBaseDO);
    }

    @Test
    public void findByXX() {
        List<UserBaseDO> userBaseDOList = userBaseRepository.findByUserName("test");
        userBaseDOList.forEach(userBaseDO -> {
            log.info("\n userBaseDO {}",userBaseDO);
        });

    }
    @Test
    public void findListByIds() {
        List<UserBaseDO> userBaseDOListQ = userBaseRepository.findListByIds("test",null,null);
        userBaseDOListQ.forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
        });
        List<UserBaseDO> userBaseDOList = userBaseRepository.findListByIds("test",new Date(), Arrays.asList(1L,2L));
        userBaseDOList.forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
        });

    }

    @Test
    @Transactional
    @Rollback
    public void updateIsDelete() {
        int result = userBaseRepository.updateIsDelete(1,1L);
        log.info("result {}",result);
    }
    @Test
    public void insert() throws IOException {
        UserBaseDO userBaseDO = new UserBaseDO();
        //userBaseDO.setId(3L);
        userBaseDO.setUserName("test");
        userBaseDO.setCode(UUID.randomUUID().toString());
        //userBaseDO.setHeadImageData(FileUtils.readFileToByteArray(new File("/Users/vonchange/work/docment/cat.jpg")));
       // userBaseDO.setCode("1");
        //userBaseDO.setCreateTime(LocalDateTime.now().plusHours(1L));
        int result  = userBaseRepository.insert(userBaseDO);
        log.info("\nresult {} {} ",result,userBaseDO.toString());
        UserBaseDO userBaseDOFind =userBaseRepository.findById(userBaseDO.getId());
        //FileUtils.writeByteArrayToFile(new File("/Users/vonchange/work/docment/catcc.jpg"),userBaseDOFind.getHeadImageData());
        log.info("\nuserBaseDOFind {}",userBaseDOFind.toString());
    }


    @Test
    public void insertDuplicateKey() {
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setUserName("UUUUU");
        userBaseDO.setMobilePhone("110");
        int result  = userBaseRepository.insertDuplicateKey(userBaseDO);
        log.info("\nresult {} {}",result,userBaseDO.getId());

    }
    @Test
    //@Transactional
    //@Rollback
    public void update() {
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setUserName("test_ss");
        userBaseDO.setId(1L);
        int result  = userBaseRepository.update(userBaseDO);
        log.info("\nresult {}",result);
        //UserBaseDO userBaseDOFind =userBaseRepository.findById(1L);
        //log.info("\nuserBaseDOFind {}",userBaseDOFind.toString());
    }

    @Test
    public void updateAllField() {
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setUserName(null);
        userBaseDO.setId(1L);
        int result  = userBaseRepository.updateAllField(userBaseDO);
        log.info("\nresult {}",result);
    }
    @Test
    public void updateBatch() {
        int result  = userBaseRepository.update(new UserBaseDO(1L,"testxx","",1,null,null));
        log.info("result {}",result);
        long start = System.currentTimeMillis();
        List<UserBaseDO> list = new ArrayList<>();
        for (int i=0;i<3;i++) {
            list.add(new UserBaseDO(1L+i,"ttt"+i,null,1,null,new Date()));
        }
        int resultx = userBaseRepository.updateBatch(list);
        log.info("result {}",resultx);
        log.info("time {}",System.currentTimeMillis()-start);
    }

    @Test
    public void updateBatchAllField() {
        int result  = userBaseRepository.update(new UserBaseDO(1L,"testxx","",1,null,null));
        log.info("result {}",result);
        long start = System.currentTimeMillis();
        List<UserBaseDO> list = new ArrayList<>();
        for (int i=0;i<3;i++) {
            list.add(new UserBaseDO(1L+i,"uuu"+i,null,null,null,new Date()));
        }
        int resultx = userBaseRepository.updateBatchAllField(list);
        log.info("result {}",resultx);
        log.info("time {}",System.currentTimeMillis()-start);
    }

    /**
     * h2 会报错 mysql 不会
     */
    @Test
    @Transactional
    public void insertBatch() {
        int result  = userBaseRepository.update(new UserBaseDO(1L,"testxx","",1,null,null));
        log.info("result {}",result);
        long start = System.currentTimeMillis();
        List<UserBaseDO> list = new ArrayList<>();
        for (int i=0;i<10000;i++) {
            list.add(new UserBaseDO(null,"冯e"+i,"1100"+i,null, LocalDateTime.now(),null));
        }
        int resultx = userBaseRepository.insertBatch(list);
        log.info("result {}",resultx);
        log.info("time {}",System.currentTimeMillis()-start);
    }

    /**
     * h2 会报错 mysql 不会
     */
    @Test
    //@Transactional
    public void insertBatchDuplicateKey() {
        int result  = userBaseRepository.update(new UserBaseDO(1L,"testxx","",1,null,null));
        log.info("result {}",result);
        long start = System.currentTimeMillis();
        List<UserBaseDO> list = new ArrayList<>();
        for (int i=0;i<9000;i++) {
            list.add(new UserBaseDO(null,"我为我的e"+i,"1100"+i,null,LocalDateTime.now(),null));
        }
        int resultx = userBaseRepository.insertBatchDuplicateKey(list);
        log.info("result {}",resultx);
        log.info("time {}",System.currentTimeMillis()-start);
    }
    @Test
    //@Transactional
    //@Rollback
    public void updateBatchBySqlId() {
        int result  = userBaseRepository.update(new UserBaseDO(1L,"testxx","",1,null,null));
        log.info("result {}",result);
        long start = System.currentTimeMillis();
        List<UserBaseDO> list = new ArrayList<>();
        for (int i=0;i<2;i++) {
            list.add(new UserBaseDO(1L+i,"RRR"+i,null,null,null,new Date()));
        }
        int resultx  = userBaseRepository.batchUpdate(list);
        log.info("resultx {}",resultx);
        log.info("time {}",System.currentTimeMillis()-start);
    }
}