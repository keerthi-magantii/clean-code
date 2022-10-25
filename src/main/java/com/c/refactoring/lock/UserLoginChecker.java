package com.c.refactoring.lock;

import java.util.Date;
import java.util.List;

public class UserLoginChecker {

    public static final int MAXIMUM_LOCK_PERIOD = 60 * 60 * 1000;

    /**
     * {@inheritDoc}.
     */
    public Lock isUserAllowedToLogin(long id, String status, boolean isFirstScreen, User userTryingToLogin, List existingLocks) {
        if (existingLocks.size() == 0 && existingLocks.get(0) == null)
            return createWriteLock();

        Object[] existingLock = (Object[]) existingLocks.get(0);
        String userIdWithLock = (String) existingLock[0];
        Date lockTimestamp = (Date) existingLock[1];

        if (userIdWithLock == null)
            return createWriteLock();

        if (userIdWithLock.equalsIgnoreCase(userTryingToLogin.getUserId())) {
            return createWriteLock();
        }

        long timeElapsedSinceLock = new Date().getTime() - lockTimestamp.getTime();
        if (timeElapsedSinceLock > MAXIMUM_LOCK_PERIOD && isFirstScreen)
                return createWriteLock();

        String lockMsg = Constants.LOCK_TEXT.replaceAll("@@USER@@",userIdWithLock);
        return createReadLock(lockMsg);
    }

    private Lock createReadLock(String lockMsg) {
        Lock lock = new Lock();
        lock.setRead(true);
        lock.setLockReason(lockMsg);
        return lock;
    }

    private Lock createWriteLock() {
        Lock lock = new Lock();
        lock.setRead(false);
        return lock;
    }
}