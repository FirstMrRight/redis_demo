package com.tea.modules.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.tea.modules.model.ScanCodeInfo;
import com.tea.modules.model.WeixinXml;

import java.io.Writer;

/**
 * com.xjm.xml<br>
 * 解析xml文件<br>
 *
 * @author xiejiemin
 * @create 2020/12/2
 */
@SuppressWarnings("all")
public class XmlReader {

    /**
     * 将对象写成XML
     */
    public static void writer() {
        WeixinXml weixinXml = WeixinXml.builder()
                .agentID(1)
                .createTime(2313131L)
                .event("scancode_waitmsg")
                .eventKey("6")
                .scanCodeInfo(ScanCodeInfo.builder().scanResult("result").scanType("123").build())
                .msgType("event")
                .fromUserName("user")
                .build();
        XStream xStream = new XStream(new DomDriver("UTF-8",new UpperCaseNameCoder()));
        xStream.alias("xml", WeixinXml.class);
        String s = xStream.toXML(weixinXml);
        System.out.println(s);
    }

    public static XStream getXStream() {
        //xstream扩展
        XStream xstream = new XStream(new XppDriver(new UpperCaseNameCoder()) {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对所有xml节点都增加CDATA标记
                    boolean cdata = true;

                    @Override
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        });
        return xstream;
    }

    public static void main(String[] args) {
        XStream xStream = getXStream();
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "<CreateTime>1408090606</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[scancode_waitmsg]]></Event>\n" +
                "<EventKey><![CDATA[6]]></EventKey>\n" +
                "<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>\n" +
                "<ScanResult><![CDATA[2]]></ScanResult>\n" +
                "</ScanCodeInfo>\n" +
                "<AgentID>1</AgentID>\n" +
                "</xml>";
        xStream.alias("xml", WeixinXml.class);
        WeixinXml weixinXml = (WeixinXml) xStream.fromXML(xml);
        System.out.println(weixinXml.toString());
        writer();
    }
}
