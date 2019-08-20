package org.escort.protocol.data;

import lombok.Builder;
import lombok.Data;
import org.escort.protocol.BaseData;

/**
 * TC call RM / TM
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:16
 */
@Data
@Builder
public class TcToRmActionRequest extends BaseData {

    @Override
    public int getTypeCode() {
        return -1;
    }
}
