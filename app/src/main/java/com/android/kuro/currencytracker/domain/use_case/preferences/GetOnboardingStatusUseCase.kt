package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject


/**
 * Use case to get the onboarding completion status.
 *
 * @property repository The repository to access shared preferences.
 */
class GetOnboardingStatusUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Retrieves the onboarding status.
     *
     * @return The onboarding status.
     */
    operator fun invoke(): Boolean {
        return repository.isOnBoardingDone
    }
}