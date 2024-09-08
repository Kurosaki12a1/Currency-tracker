package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

/**
 * Use case to set the onboarding completion status.
 *
 * @property repository The repository to access shared preferences.
 */
class SetOnboardingStatusUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Sets the onboarding status.
     *
     * @param isOnboardingDone The onboarding status to set.
     */
    operator fun invoke(isOnboardingDone: Boolean) {
        repository.isOnBoardingDone = isOnboardingDone
    }
}