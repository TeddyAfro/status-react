(ns status-im.ui.screens.intro.views
  (:require-macros [status-im.utils.views :refer [defview letsubs]])
  (:require [status-im.ui.components.react :as react]
            [re-frame.core :as re-frame]
            [status-im.ui.components.common.common :as components.common]
            [status-im.ui.screens.intro.styles :as styles]
            [status-im.i18n :as i18n]
            [status-im.ui.components.status-bar.view :as status-bar]
            [status-im.ui.screens.privacy-policy.views :as privacy-policy]))

(defview intro []
  [react/view {:style styles/intro-view}
   [status-bar/status-bar {:flat? true}]
   [react/view {:style styles/intro-logo-container}
    [components.common/logo styles/intro-logo]]
   [react/i18n-text {:style styles/intro-text
                     :key   :intro-text}]
   [react/view
    [react/i18n-text {:style styles/intro-text-description
                      :key   :intro-text-description}]]
   [react/view styles/buttons-container
    [components.common/button {:button-style {:flex-direction :row}
                               :on-press     #(re-frame/dispatch [:accounts.create.ui/create-new-account-button-pressed])
                               :label        (i18n/label :t/create-account)}]
    [react/view styles/bottom-button-container
     [components.common/button {:on-press    #(re-frame/dispatch [:accounts.recover.ui/recover-account-button-pressed])
                                :label       (i18n/label :t/already-have-account)
                                :background? false}]]
    [privacy-policy/privacy-policy-button]]])
