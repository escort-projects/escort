package org.escort.sample.tcc.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 余额
     */
    private BigDecimal balance;
}
