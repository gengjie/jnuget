package ru.aristar.jnuget;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sviridov
 */
class PackageInfoGenerator {

    private String getTitle() {
        return "title";
    }

    private String getAuthor() {
        return "Author";
    }

    private String getDescription() {
        return "description";
    }

    private List<SyndEntry> getEntries() {
        ArrayList<SyndEntry> entrys = new ArrayList<SyndEntry>();
        SyndEntry entry = new SyndEntryImpl();
        entry.setAuthor("Author");
        entry.setTitle("Title");
        entry.setLink("url");
        entry.setUri("url");
        entry.setPublishedDate(new Date());
        //entry.setCategories(Arrays.asList(categories));
        SyndContent description = new SyndContentImpl();
        description.setType("sdas");
        description.setValue("sdkjaldkjldkj");
        entry.setDescription(description);
        entrys.add(entry);
        return entrys;
    }

    private String getUrl() {
        return "http://url";
    }
    
    /*
     * <?xml version="1.0" encoding="windows-1251" standalone="yes"?>
<feed xml:base="http://office.neolant.ru:8090/nuget/nuget/" 
     xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices" 
     xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" 
     xmlns="http://www.w3.org/2005/Atom">
  <title type="text">Packages</title>
  <id>http://office.neolant.ru:8090/nuget/nuget/Packages</id>
  <updated>2011-10-08T06:49:38Z</updated>
  <link rel="self" title="Packages" href="Packages" />
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Moq',Version='4.0.10827')</id>
    <title type="text">Moq</title>
    <summary type="text"></summary>
    <updated>2011-09-23T05:58:21Z</updated>
    <author>
      <name>Moq</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Moq',Version='4.0.10827')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Moq',Version='4.0.10827')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Moq/4.0.10827" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>4.0.10827</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Mock для unit тестов</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-23T05:58:43.8858747Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>eoLGkBGTbHl1QsfOcTAx4mmIuTRs8e+wvxhaERmEuqjUSHiTdmiqRrtE1+exxR3Rh5ar0H3QXbGPpR9XsIqK2Q==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">543005</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unit test Mock </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='MSBuild.Community.Tasks',Version='1.2.0.306')</id>
    <title type="text">MSBuild.Community.Tasks</title>
    <summary type="text"></summary>
    <updated>2011-09-23T06:29:58Z</updated>
    <author>
      <name>MSBuild.Community</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='MSBuild.Community.Tasks',Version='1.2.0.306')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='MSBuild.Community.Tasks',Version='1.2.0.306')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/MSBuild.Community.Tasks/1.2.0.306" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>1.2.0.306</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Дополнительные task для MSBuild</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-23T06:30:05.1869954Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>abV9XQeVF4MFBa5Kmq1dLPna4za+ELvf20hVto1fWVFto/B/N+kZZnRVGymzArd73O0nZ0El7IQQ6IF4yLBbcw==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">226957</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> MSBuild task </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.557')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-26T06:56:36Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.557')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.557')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.557" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.557</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-26T06:56:35.9946285Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>MSBuild.Community.Tasks:1.2.0.306</d:Dependencies>
      <d:PackageHash>jPQ1CIz5RO+z9BBAjRRxlHH5Do5XCQXvRy3ungmG4AIuopw5gcxLikYLlzTPZ0eN+La/JlnR2wx6ecUKTd7y9g==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">12606</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.558')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-26T08:34:35Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.558')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.558')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.558" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.558</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-26T08:34:35.6404562Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>MSBuild.Community.Tasks:1.2.0.306</d:Dependencies>
      <d:PackageHash>PwT3IPuCO24OyMtCd5fh/8fAYsb2okVVmzGcyJmcKAvVXdCj5WR+S8Y4W5tHm+rbG2zk8P4KpSAqqmYWenY+BQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">12596</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.563')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-27T05:49:15Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.563')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.563')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.563" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.563</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-27T05:49:15.0496393Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>MSBuild.Community.Tasks:1.2.0.306</d:Dependencies>
      <d:PackageHash>edxeTjphhU7Ci21UVVNVa1e3tr8+Y8RBDpyfoF3QstiTwz0P+nZ9+r/S7Qwn51yKD/KsbvqYt+j99RlciV1T7w==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">12577</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.566')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-28T10:27:49Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.566')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.566')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.566" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.566</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-28T10:27:49.5829086Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>MSBuild.Community.Tasks:1.2.0.306</d:Dependencies>
      <d:PackageHash>69Nz/IGUJiqMBFCItnNAAOSNrGnX64zxsCXRZzfhgBJp0AuYpn7SGNHZcOlet0ZSRAM4WlLqJtV8caWikbGnfA==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">12579</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.567')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-28T12:00:54Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.567')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.567')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.567" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.567</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-28T12:00:54.2553153Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>MSBuild.Community.Tasks:1.2.0.306</d:Dependencies>
      <d:PackageHash>S0vc5L17RWceeop+qsJwgjMYR8cm6HZAg7YkbSvjJXwowpmKQ5BqouRIJ+3eBqmDK6w3N12D/q2apRoHqzR2Tw==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">12599</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.569')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-28T12:19:36Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.569')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.569')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.569" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.569</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-28T12:19:36.0934879Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>MSBuild.Community.Tasks:1.2.0.306</d:Dependencies>
      <d:PackageHash>Nuu+62yArZmOPLiTPcQVShZHe9LrJaTwc7gXvAeC/qbplVI3NNypoOlokcWEQvdan+ibX44tlSgwTRUGpdvVyQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">12599</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.576')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-30T05:19:21Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.576')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.576')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.576" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.576</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-30T05:07:56.0679806Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>Neolant.IOT.EventBus:0.0.2.569</d:Dependencies>
      <d:PackageHash>QpFfDPMZpsk3KRoArFZ/DploAhMODDMlAQBZLk4TXS6UNYDk46qJszvVlDOGUcb4Zt3997Sx7qeX3TpuFWwd8g==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">13091</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.579')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-09-30T05:26:57Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.579')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.579')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.579" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.579</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-30T05:26:57.526262Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>FZZXsZBI6OI4j5Nu0K0bTSRsjf27BYmHtvST1lNviFyCpqKISB3wGaOu3EO9XvgVQ/yBbCtD2IMIbYCbZpqQTQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">13060</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.580')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-10-03T09:54:45Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.580')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.580')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.580" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.580</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-30T05:34:25.330262Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>1rj7O9anVFTpkarSQpTGDceD8aiE9KxY2vtPLRdasLbzp40nAncqyV+GMiLbtuhGmDyDFOO7pGkN4trYtwg8gg==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">13058</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.610')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-10-07T09:12:18Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.610')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.610')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.610" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.610</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-05T08:49:56.8739957Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>G5Cf+MrbQH2AuSTDNnNihn4VO7cP8ys2R+1aHZCXG71DX7OOBjeK6hsqXTyPwzpcRkm7qaTpFdY2ANJRBTocug==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">13050</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.619')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-10-07T10:03:01Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.619')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.619')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.619" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.619</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-07T10:03:01.1834933Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>rSNTZqt/tHcPFSdPQ/N6r5lWkm8f3AV/4Qj6cScJq8lsXYWOgaKEZtZVAnxMjiPy+UHz+2djES/PEdDSpI0/yw==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">13258</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.620')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-10-07T10:31:50Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.620')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.620')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.620" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.620</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-07T10:31:50.6633201Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>8AddVCOlYXEa9ThF5DVnbbvJcJIAUFrDIszs2KNm6XHijLl/Irv9HL+T9qSKCzGS+jIfbKfDpi3a5yLteSCXuw==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">13260</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.622')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-10-07T11:50:18Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.622')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.622')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.622" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.622</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-07T11:50:18.2735799Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>NLog:2.0.0.2000</d:Dependencies>
      <d:PackageHash>YrnfHCb+ejLHc3nrrXDyvwLueWqBSJDyCDKZOeHs9B3dlm1CF1O1nXCLAEz/p7NAl+6BFbpbLBA6AJzdTKZ0cA==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">15303</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.623')</id>
    <title type="text">Neolant.IOT.EventBus</title>
    <summary type="text"></summary>
    <updated>2011-10-07T12:59:52Z</updated>
    <author>
      <name>ЗАО "НЕОЛАНТ"</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.623')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.EventBus',Version='0.0.2.623')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.EventBus/0.0.2.623" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.623</d:Version>
      <d:Title>EventBus</d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Шина обмена сообщениями между компонентами приложения</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-07T12:59:51.9859556Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies>NLog:2.0.0.2000</d:Dependencies>
      <d:PackageHash>8mINv5Wi8AJZ0jFVDRs13gGj3AAJc/zxm8et/ZVq3Bowsg+8fO9o120X7EcEUolgbv5MxeEq1NJYcyjczQRELQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">15308</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> IOT Bus </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.0')</id>
    <title type="text">Neolant.IOT.Simulator</title>
    <summary type="text"></summary>
    <updated>2011-09-29T13:26:04Z</updated>
    <author>
      <name>NEOLANT</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.0')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.0')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.Simulator/0.0.2.0" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.0</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Package description</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-29T13:26:04.6391789Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>sUDwQyFeGeip3HDgm3XI8+5Lhoxv6uBGdfJ62DSmQT5hNrmZpZDe5kJ3qvY8ctw+ojt5cb0igbATupkbY9KbeQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">17249574</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Tag1 Tag2 </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.584')</id>
    <title type="text">Neolant.IOT.Simulator</title>
    <summary type="text"></summary>
    <updated>2011-09-30T12:02:02Z</updated>
    <author>
      <name>NEOLANT</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.584')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.584')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.Simulator/0.0.2.584" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.584</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Симулятор работы по демонтажу реактора</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-30T12:02:02.6950378Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>k+mOBoOT3Ok7gdvW/16swl4aeTS3h7y9sdIHzsmarZcNPTd//PUDvPq0pyH33oNV1DGnLBi7SKDV+ojuAOBG0Q==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">18139283</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Simulator IOT Brokk </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.591')</id>
    <title type="text">Neolant.IOT.Simulator</title>
    <summary type="text"></summary>
    <updated>2011-10-03T10:51:47Z</updated>
    <author>
      <name>NEOLANT</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.591')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.591')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.Simulator/0.0.2.591" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.591</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Симулятор работы по демонтажу реактора</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-03T10:15:38.2443778Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>W+C/JGaozOMhQuJU52AFnZcrSDd1hiNATA8SYFSqq+y62ckF9goNFTEveXwrkLSUTPVNQCWycLQf08F3jhahig==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">18746062</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Simulator IOT Brokk </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.600')</id>
    <title type="text">Neolant.IOT.Simulator</title>
    <summary type="text"></summary>
    <updated>2011-10-04T05:02:50Z</updated>
    <author>
      <name>NEOLANT</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.600')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.600')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.Simulator/0.0.2.600" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.600</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Симулятор работы по демонтажу реактора</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-04T05:16:18.1633603Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>rTwWe0YZFZ77ACx37J0fUGyjmkQMPErG91HP19vRGCafRwQuGEJ+Z/EhmMeM8vT9HQPbQXRkSj3ZIuSYHGJaog==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">18745557</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Simulator IOT Brokk </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.608')</id>
    <title type="text">Neolant.IOT.Simulator</title>
    <summary type="text"></summary>
    <updated>2011-10-05T07:34:06Z</updated>
    <author>
      <name>NEOLANT</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.608')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Neolant.IOT.Simulator',Version='0.0.2.608')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Neolant.IOT.Simulator/0.0.2.608" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>0.0.2.608</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Симулятор работы по демонтажу реактора</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-05T08:14:02.9545968Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>d3ZD7qAIs3XHMBRAb+uC8aggMJP3n47UsDsvafFAg1XGmhh7QYkgst5ucHNJ2NSaLsD8eMFmehfAR8c5bVLmFQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">18745394</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Simulator IOT Brokk </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='NLog',Version='2.0.0.2000')</id>
    <title type="text">NLog</title>
    <summary type="text">NLog - Advanced .NET and Silverlight Logging</summary>
    <updated>2011-10-07T11:47:15Z</updated>
    <author>
      <name>Jaroslaw Kowalski</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='NLog',Version='2.0.0.2000')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='NLog',Version='2.0.0.2000')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/NLog/2.0.0.2000" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>2.0.0.2000</d:Version>
      <d:Title>NLog</d:Title>
      <d:IconUrl>http://nlog-project.org/N.png</d:IconUrl>
      <d:LicenseUrl>https://raw.github.com/jkowalski/NLog/master/LICENSE.txt</d:LicenseUrl>
      <d:ProjectUrl>http://nlog-project.org/</d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>NLog is a logging platform for .NET with rich log routing and management capabilities. It can help you produce and manage high-quality logs for your application regardless of its size or complexity.
This package installs NLog.dll with includes core logging functionality.
For your main project also need to install "NLog Configuration" package.</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language>en-US</d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-07T09:54:10.7724323Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>VzBDd15Ai2QnGLuThlxgnSO98TKWwojpMj/JoVf6CK2bVyIPuVbsvIQhPpF7iSbFa/+mM4JOv05Q3fwS99iEYQ==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">1628952</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags m:null="true"></d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='NUnit',Version='2.5.9.10348')</id>
    <title type="text">NUnit</title>
    <summary type="text"></summary>
    <updated>2011-09-23T05:30:48Z</updated>
    <author>
      <name>NUnit</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='NUnit',Version='2.5.9.10348')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='NUnit',Version='2.5.9.10348')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/NUnit/2.5.9.10348" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>2.5.9.10348</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Пакет модульного тестирования</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-09-23T05:18:55.5327281Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>CoknSJBGJ7kao2P6y9E9BuL1IkhP5LLhZ+ImtsgdxzFDpjs0QtRVOV8kxysakJu3cvw5O0hImcnVloCaQ9+Nmg==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">214905</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unit test </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Unity3d.Launcher',Version='3.3.0.4')</id>
    <title type="text">Unity3d.Launcher</title>
    <summary type="text"></summary>
    <updated>2011-10-05T07:39:15Z</updated>
    <author>
      <name>Unity3d</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Unity3d.Launcher',Version='3.3.0.4')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Unity3d.Launcher',Version='3.3.0.4')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Unity3d.Launcher/3.3.0.4" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>3.3.0.4</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Исполняемый файл, загружающий сцену</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-05T07:59:09.2352338Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>2bBJ1P1fLjsbYVNNCp8DjYTYNSgkIEOe9K1wDwxfZ8ocTsbuJZABmgYqQ9kn4MoIVP1tOFDtBsVh0LTiGb5fAA==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">4169566</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Launcher .net </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Unity3d.Libraries',Version='3.3.0.4')</id>
    <title type="text">Unity3d.Libraries</title>
    <summary type="text"></summary>
    <updated>2011-10-05T07:39:18Z</updated>
    <author>
      <name>Unity3d</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Unity3d.Libraries',Version='3.3.0.4')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Unity3d.Libraries',Version='3.3.0.4')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Unity3d.Libraries/3.3.0.4" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>3.3.0.4</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>Исполняемый файл, загружающий сцену</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-05T07:59:09.2492352Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>pHabLdF6x129pCbOqCdASd8PFIIjprHRUvdvErFDQdqCiNWcJpFQGmH2X3hMY+9uwBWomIcVbv+aESYkNugm4g==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">3538889</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Libraries .net </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>
  <entry>
    <id>http://office.neolant.ru:8090/nuget/nuget/Packages(Id='Unity3d.mono',Version='3.3.0.4')</id>
    <title type="text">Unity3d.mono</title>
    <summary type="text"></summary>
    <updated>2011-10-05T07:39:10Z</updated>
    <author>
      <name>Unity3d</name>
    </author>
    <link rel="edit-media" title="Package" href="Packages(Id='Unity3d.mono',Version='3.3.0.4')/$value" />
    <link rel="edit" title="Package" href="Packages(Id='Unity3d.mono',Version='3.3.0.4')" />
    <category term="NuGet.Server.DataServices.Package" scheme="http://schemas.microsoft.com/ado/2007/08/dataservices/scheme" />
    <content type="application/zip" src="http://office.neolant.ru:8090/nuget/download/Unity3d.mono/3.3.0.4" />
    <m:properties xmlns:m="http://schemas.microsoft.com/ado/2007/08/dataservices/metadata" xmlns:d="http://schemas.microsoft.com/ado/2007/08/dataservices">
      <d:Version>3.3.0.4</d:Version>
      <d:Title m:null="true"></d:Title>
      <d:IconUrl m:null="true"></d:IconUrl>
      <d:LicenseUrl m:null="true"></d:LicenseUrl>
      <d:ProjectUrl m:null="true"></d:ProjectUrl>
      <d:ReportAbuseUrl m:null="true"></d:ReportAbuseUrl>
      <d:DownloadCount m:type="Edm.Int32">-1</d:DownloadCount>
      <d:VersionDownloadCount m:type="Edm.Int32">-1</d:VersionDownloadCount>
      <d:RatingsCount m:type="Edm.Int32">0</d:RatingsCount>
      <d:VersionRatingsCount m:type="Edm.Int32">-1</d:VersionRatingsCount>
      <d:Rating m:type="Edm.Double">-1</d:Rating>
      <d:VersionRating m:type="Edm.Double">-1</d:VersionRating>
      <d:RequireLicenseAcceptance m:type="Edm.Boolean">false</d:RequireLicenseAcceptance>
      <d:Description>.NET машина для Unity</d:Description>
      <d:ReleaseNotes m:null="true"></d:ReleaseNotes>
      <d:Language m:null="true"></d:Language>
      <d:Published m:type="Edm.DateTime">2011-10-05T07:59:09.2622365Z</d:Published>
      <d:Price m:type="Edm.Decimal">0</d:Price>
      <d:Dependencies></d:Dependencies>
      <d:PackageHash>/3SELTK1s9CydEEjjVSl+AbVSaE4ImV71HmX8W8SVZbjOSagJOi0pJduuOnp3I77mRdPufHsoKyOysl9hDbANA==</d:PackageHash>
      <d:PackageSize m:type="Edm.Int64">1427424</d:PackageSize>
      <d:ExternalPackageUri m:null="true"></d:ExternalPackageUri>
      <d:Categories m:null="true"></d:Categories>
      <d:Copyright m:null="true"></d:Copyright>
      <d:PackageType m:null="true"></d:PackageType>
      <d:Tags xml:space="preserve"> Unity Mono .net </d:Tags>
      <d:IsLatestVersion m:type="Edm.Boolean">true</d:IsLatestVersion>
      <d:Summary m:null="true"></d:Summary>
    </m:properties>
  </entry>

</feed>
     */

    public enum SyndFeedType {

        RSS_09("rss_0.9"),
        RSS_091("rss_0.91"),
        RSS_092("rss_0.92"),
        RSS_093("rss_0.93"),
        RSS_O94("rss_0.94"),
        RSS_10("rss_1.0"),
        RSS_20("rss_2.0"),
        ATOM_03("atom_0.3"),
        ATOM_10("atom_1.0");
        private String code;

        private SyndFeedType(String code) {

            this.code = code;

        }

        public String getCode() {

            return code;

        }
    }

    public SyndFeed makeFeed() {
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType(getType());
        feed.setAuthor(getAuthor());
        feed.setCopyright(getAuthor());
        feed.setTitle(getTitle());
        feed.setDescription(getDescription());
        feed.setLink(getUrl());
        feed.setUri(getUrl());
        feed.setEntries(getEntries());
        return feed;
    }

    private String getType() {
        return SyndFeedType.ATOM_10.getCode();
    }
}
