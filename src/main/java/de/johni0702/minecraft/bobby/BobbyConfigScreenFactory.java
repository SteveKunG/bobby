package de.johni0702.minecraft.bobby;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.IntegerListEntry;
import me.shedaniel.clothconfig2.gui.entries.IntegerSliderEntry;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

import java.util.function.Consumer;

public class BobbyConfigScreenFactory {
    public static Screen createConfigScreen(Screen parent, BobbyConfig config, Consumer<BobbyConfig> update) {
        BobbyConfig defaultConfig = BobbyConfig.DEFAULT;

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(new TranslatableText("title.bobby.config"));


        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        BooleanListEntry enabled = entryBuilder
                .startBooleanToggle(new TranslatableText("option.bobby.enabled"), config.isEnabled())
                .setDefaultValue(defaultConfig.isEnabled())
                .build();

        IntegerListEntry maxRenderDistance = entryBuilder
                .startIntField(new TranslatableText("option.bobby.max_render_distance"), config.getMaxRenderDistance())
                .setTooltip(new TranslatableText("tooltip.option.bobby.max_render_distance"))
                .setDefaultValue(defaultConfig.getMaxRenderDistance())
                .build();

        IntegerSliderEntry viewDistanceOverwrite = entryBuilder
                .startIntSlider(new TranslatableText("option.bobby.view_distance_overwrite"), config.getViewDistanceOverwrite(), 0, 16)
                .setTooltip(new TranslatableText("tooltip.option.bobby.view_distance_overwrite"))
                .setDefaultValue(defaultConfig.getViewDistanceOverwrite())
                .build();

        ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("category.bobby.general"));
        general.addEntry(enabled);
        general.addEntry(maxRenderDistance);
        general.addEntry(viewDistanceOverwrite);

        builder.setSavingRunnable(() -> update.accept(new BobbyConfig(
                enabled.getValue(),
                maxRenderDistance.getValue(),
                viewDistanceOverwrite.getValue()
        )));

        return builder.build();
    }
}