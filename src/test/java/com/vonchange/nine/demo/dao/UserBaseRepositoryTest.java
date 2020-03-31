package com.vonchange.nine.demo.dao;

import com.vonchange.nine.demo.domain.UserBaseDO;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


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
        List<UserBaseDO> userBaseDOList = userBaseRepository.findList("张三日子",null);
        userBaseDOList.forEach(userBaseDO -> {
            log.info("\n {}",userBaseDO.toString());
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
    public void insert() {
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setUserName("test");
        Long  id  = userBaseRepository.insert(userBaseDO);
        log.info("\nresult {}",id);
    }

    @Test
    public void insertDuplicateKey() {
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setUserName("UUUUU");
        userBaseDO.setFirstPhone("110");
        Long  id  = userBaseRepository.insertDuplicateKey(userBaseDO);
        log.info("\nresult {}",id);
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
        UserBaseDO userBaseDOFind =userBaseRepository.findById(1L);
        log.info("\nuserBaseDOFind {}",userBaseDOFind.toString());
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
        for (int i=0;i<6;i++) {
            list.add(new UserBaseDO(null,"冯e"+i,"1100"+i,null,new Date(),null));
        }
        int resultx = userBaseRepository.insertBatch(list);
        log.info("result {}",resultx);
        log.info("time {}",System.currentTimeMillis()-start);
    }

    @Test
    //@Transactional
    public void insertBatchDuplicateKey() {
        int result  = userBaseRepository.update(new UserBaseDO(1L,"testxx","",1,null,null));
        log.info("result {}",result);
        long start = System.currentTimeMillis();
        List<UserBaseDO> list = new ArrayList<>();
        for (int i=0;i<9000;i++) {
            list.add(new UserBaseDO(null,"我为我的e"+i,"1100"+i,null,new Date(),null));
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