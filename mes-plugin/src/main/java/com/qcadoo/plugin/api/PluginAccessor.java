package com.qcadoo.plugin.api;

import java.util.Collection;


public interface PluginAccessor {

    PersistentPlugin getEnabledPlugin(String pluginKey);

    Collection<Plugin> getEnabledPlugins();

    Plugin getPlugin(String name);

    Collection<Plugin> getPlugins();

}