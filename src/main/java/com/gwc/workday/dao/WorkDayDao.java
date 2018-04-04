package com.gwc.workday.dao;

import com.gwc.workday.entity.WorkDay;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 工作日dao
 *
 * @author chenggaowei
 * @version V1.0
 * @description: usejpa
 * @date 2017-09-21 22:04
 */
public interface WorkDayDao extends JpaRepository<WorkDay, Integer> {

  /**
   * 根据日期查询节假日
   * @param date
   * @return
   */
  WorkDay findFirstByDate(String date);

  /**
   * 某天之后的所有节假日
   * @param date 计算机日期
   * @param sort 排序
   * @return
   */
  List<WorkDay> findByDateGreaterThanEqual(String date, Sort sort);

  /**
   * 查询两个日期之间的节假日
   * @param start 开始日期
   * @param end 结束日期
   * @param sort 排序
   * @return
   */
  List<WorkDay> findByDateBetween(String start, String end, Sort sort);
}
