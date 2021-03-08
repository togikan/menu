package com.thk.menu

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.thk.menu.base.di.baseModule
import com.thk.menu.core.feature.FeatureManager
import com.thk.menu.core.kodein.FragmentArgsExternalSource
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class MenuApplication : SplitCompatApplication(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MenuApplication))
        import(appModule)
        import(baseModule)
        importAll(FeatureManager.kodeinModules)
        externalSources.add(FragmentArgsExternalSource())
    }

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this
    }
}