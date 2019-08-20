package org.escort.protocol;

import org.escort.protocol.data.RmToTcReportRequest;
import org.escort.serializer.JdkSerializer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/20 19:03
 */
public class BaseEventTest {

    @Test
    public void test() {
        RmToTcReportRequest originRequest = new RmToTcReportRequest(1, 2, 3);
        originRequest.setArguments(new ArrayList<>());
        BaseEvent originEvent = new BaseEvent("processorId", originRequest);
        JdkSerializer jdkSerializer = new JdkSerializer();
        byte[] bytes = jdkSerializer.serialize(originEvent);
        BaseEvent decodeEvent = jdkSerializer.deserialize(bytes, BaseEvent.class);
        Assert.assertNotNull(decodeEvent);
        Assert.assertEquals(originRequest.getTypeCode(), decodeEvent.getMessage().getTypeCode());
        RmToTcReportRequest decodeRequest = decodeEvent.caseData(RmToTcReportRequest.class);
        Assert.assertEquals(originRequest.getXid(), decodeRequest.getXid());
    }
}
