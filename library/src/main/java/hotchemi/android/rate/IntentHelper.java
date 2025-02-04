package hotchemi.android.rate;

import android.content.Context;
import android.content.Intent;

import static hotchemi.android.rate.UriHelper.getGooglePlay;
import static hotchemi.android.rate.UriHelper.getAmazonAppstore;
import static hotchemi.android.rate.UriHelper.getHuaweiAppGallery;
import static hotchemi.android.rate.UriHelper.isPackageExists;

final class IntentHelper {

    private static final String GOOGLE_PLAY_PACKAGE_NAME = "com.android.vending";

    private static final String HUAWEI_APP_GALLERY_PACKAGE_NAME = "com.huawei.appmarket";

    private IntentHelper() {
    }

    static Intent createIntentForGooglePlay(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent(Intent.ACTION_VIEW, getGooglePlay(packageName));
        if (isPackageExists(context, GOOGLE_PLAY_PACKAGE_NAME)) {
            intent.setPackage(GOOGLE_PLAY_PACKAGE_NAME);
        }
        return intent;
    }

    static Intent createIntentForAmazonAppstore(Context context) {
        String packageName = context.getPackageName();
        return new Intent(Intent.ACTION_VIEW, getAmazonAppstore(packageName));
    }

    static Intent createIntentForHuaweiAppGallery(Context context) {
        final String packageName = context.getPackageName();
        final Intent intent = new Intent(Intent.ACTION_VIEW, getHuaweiAppGallery(packageName));
        intent.setPackage(HUAWEI_APP_GALLERY_PACKAGE_NAME);
        return intent;
    }
}
