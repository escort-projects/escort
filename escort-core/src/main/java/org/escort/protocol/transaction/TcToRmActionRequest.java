package org.escort.protocol.transaction;

import lombok.Builder;
import lombok.Data;
import org.escort.protocol.TypeCodeDefine;

/**
 * TC call RM / TM
 *
 * @Author: Shoukai Huang
 * @Date: 2019/8/1 19:16
 */
@Data
@Builder
public class TcToRmActionRequest extends AbstractRequest {

    @Override
    public int getTypeCode() {
        return -1;
    }
}
