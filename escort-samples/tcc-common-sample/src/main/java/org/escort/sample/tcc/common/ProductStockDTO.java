package org.escort.sample.tcc.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/2 10:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockDTO {
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 库存
     */
    private Integer stock;
}
