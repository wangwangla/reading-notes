# 15 手持平台上的OpenGL ES和EGL

到目前为止，您应该已经熟悉了OpenGL ES 2.0和EGL 1.3的细节。在最后一章中，我们从api的细节转移到讨论在现实世界中使用OpenGL ES  2.0和EGL进行编程。在为OpenGL ES  2.0开发应用程序时，市场上有各种各样的手持平台，它们带来了一些有趣的问题和挑战。在此，我们试图通过讨论这些手持平台问题来覆盖这些问题:

By now, you should be familiar with the details of OpenGL ES 2.0 and EGL 1.3. In the final chapter, we divert ourselves a bit from the details of the APIs to talk about programming with OpenGL ES 2.0 and EGL in the real world. There are a diverse set of handheld platforms in the market that pose some interesting issues and challenges when developing applications for OpenGL ES 2.0. Here, we seek to cover some of those issues by discussing these hand-held platform issues:

- C++的可移植性
- OpenKODE
- 平台特定着色器二进制文件
- 针对扩展

## Handheld Platforms Overview

手持平台概述

Knowing OpenGL ES 2.0 and EGL 1.3 is a critical step to writing games and  applications for handheld platforms. However, a big part of the challenge in  targeting handheld devices is coping with the diversity of platforms. One of the  biggest issues today in the handheld market is the fragmentation in development  capabilities and environments available on handheld platforms. Let’s start by  taking a look at some of the biggest platforms out there today.

了解OpenGL ES 2.0和EGL 1.3是为手持平台编写游戏和应用程序的关键步骤。然而，瞄准手持设备的一大挑战是应对平台的多样性。当今手持市场最大的问题之一是手持平台上的开发能力和环境的碎片化。让我们先来看看当今最大的一些平台。

In addition to operating systems (OSs), a wide variety of CPUs are in use. Most of the architectures are based on the ARM processor family, which supports a wide variety of features. Some CPUs support floating-point natively, whereas others do not. Targeting ARM means you need to be cognizant of aligning data to 32-bit boundaries and potentially providing your own fast floating-point emulation library (or using fixed-point math)

除了操作系统(os)之外，还在使用各种各样的cpu。大多数架构都基于ARM处理器家族，该处理器家族支持各种各样的特性。有些cpu本身支持浮点数，而有些则不支持。以ARM为目标意味着您需要认识到将数据对齐到32位边界，并可能提供自己的快速浮点模拟库(或使用定点数学)

