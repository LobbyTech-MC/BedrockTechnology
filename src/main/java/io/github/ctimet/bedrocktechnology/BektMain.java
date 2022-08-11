package io.github.ctimet.bedrocktechnology;

import io.github.ctimet.bedrocktechnology.plugin.PluginManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BektMain extends JavaPlugin implements SlimefunAddon {
    private static BektMain instance;
    @Override
    public void onEnable() {
        instance = this;
        PluginManager.startBekt();
        getLogger().info("这只是个用于测试自动更新的测试版本");
        new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "BedrockTechnology", "master", false).start();
    }

    @Override
    public void onDisable() {
        PluginManager.stopBekt();
    }

    @NotNull
    public static BektMain getInstance() {
        return instance;
    }

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return instance;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return "https://github.com/CTimet/BedrockTechnology/issues";
    }
}
