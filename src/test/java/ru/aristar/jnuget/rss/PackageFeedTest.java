package ru.aristar.jnuget.rss;

import java.io.InputStream;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Тест класса RSS
 *
 * @author sviridov
 */
public class PackageFeedTest {

    /**
     * Распознает дату в XMl W3C формате
     *
     * @param date строка с датой/временем
     * @return распознанная дата
     */
    private Date parseXmlDate(String date) {
        return javax.xml.bind.DatatypeConverter.parseDateTime(date).getTime();
    }

    /**
     * Проверка корректного преобразования пакета в XML
     *
     * @throws Exception
     */
    @Test
    public void testUnmarshallFeed() throws Exception {
        //GIVEN
        InputStream inputStream = PackageFeedTest.class.getResourceAsStream("/rss_feed.xml");
        //WHEN
        PackageFeed packageFeed = PackageFeed.parse(inputStream);
        //THEN
        assertEquals("Идентификатор", "http://localhost:8090/nuget/nuget/Packages", packageFeed.getId());
        assertEquals("Дата обновления", parseXmlDate("2011-10-08T06:49:38Z"), packageFeed.getUpdated());
        assertEquals("Количество пакетов", 26, packageFeed.getEntries().size());
        fail("Тест реализован не до конца");
    }
}