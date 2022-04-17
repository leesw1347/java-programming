package ch15.part03.main8.sub2;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnection_Redirect {
    public static void main(String[] args) throws IOException {
        String url = "https://naver.com";
        final URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        final InputStream is = openConnectionCheckRedirects(urlConnection);
        System.out.println(is);
//        System.out.println(is.readAllBytes());
    }

    private static InputStream openConnectionCheckRedirects(URLConnection urlConnection) throws IOException {
        boolean isRedirect = false;
        int redirectCount = 0;
        InputStream inputStream = null;
        do {
            if (urlConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) urlConnection).setInstanceFollowRedirects(false);
            }
            inputStream = urlConnection.getInputStream();
            isRedirect = false;

            if (urlConnection instanceof HttpURLConnection) {
                final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                final int statusCode = httpURLConnection.getResponseCode();
                if (statusCode >= 300 && statusCode <= 307 &&
                        statusCode != 306 && statusCode != HttpURLConnection.HTTP_NOT_MODIFIED) {
                    final URL baseUrl = httpURLConnection.getURL();
                    final String location = httpURLConnection.getHeaderField("Location");
                    final URL target = location == null ? null : new URL(baseUrl, location);

                    System.out.println("baseUrl was " + baseUrl);
                    System.out.println("location was  " + location);
                    System.out.println("target was " + target);

                    httpURLConnection.disconnect();
                    if (target == null || !(target.getProtocol().equals("http") || target.getProtocol().equals("https")) || redirectCount >= 5) {
                        throw new SecurityException("illegal URL redirect");
                    }
                    isRedirect = true;
                    urlConnection = target.openConnection();
                    redirectCount++;
                }
                break;
            }
        } while (isRedirect);
        return inputStream;
    }
}

