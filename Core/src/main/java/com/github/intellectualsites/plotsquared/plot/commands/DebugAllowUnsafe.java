/*
 *       _____  _       _    _____                                _
 *      |  __ \| |     | |  / ____|                              | |
 *      | |__) | | ___ | |_| (___   __ _ _   _  __ _ _ __ ___  __| |
 *      |  ___/| |/ _ \| __|\___ \ / _` | | | |/ _` | '__/ _ \/ _` |
 *      | |    | | (_) | |_ ____) | (_| | |_| | (_| | | |  __/ (_| |
 *      |_|    |_|\___/ \__|_____/ \__, |\__,_|\__,_|_|  \___|\__,_|
 *                                    | |
 *                                    |_|
 *            PlotSquared plot management system for Minecraft
 *                  Copyright (C) 2020 IntellectualSites
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.intellectualsites.plotsquared.plot.commands;

import com.github.intellectualsites.plotsquared.commands.CommandDeclaration;
import com.github.intellectualsites.plotsquared.plot.config.Captions;
import com.github.intellectualsites.plotsquared.plot.object.PlotPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CommandDeclaration(command = "debugallowunsafe",
    description = "Allow unsafe actions until toggled off",
    usage = "/plot debugallowunsafe",
    category = CommandCategory.DEBUG,
    requiredType = RequiredType.NONE,
    permission = "plots.debugallowunsafe")
public class DebugAllowUnsafe extends SubCommand {

    public static final List<UUID> unsafeAllowed = new ArrayList<>();

    @Override public boolean onCommand(PlotPlayer player, String[] args) {

        if (unsafeAllowed.contains(player.getUUID())) {
            unsafeAllowed.remove(player.getUUID());
            sendMessage(player, Captions.DEBUGALLOWUNSAFE_OFF);
        } else {
            unsafeAllowed.add(player.getUUID());
            sendMessage(player, Captions.DEBUGALLOWUNSAFE_ON);
        }
        return true;
    }

}
